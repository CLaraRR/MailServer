package entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KillPortMethod {
	private static Set<Integer> ports;
	 
	public static void main(String[] args){
		KillPortMethod test=new KillPortMethod(4555);
		test.start();

	}

	public KillPortMethod(Integer port){
		ports=new HashSet<Integer>();
		ports.add(port);
	}
	
	public void start(){
		for(Integer port:ports){
			killPort(port);
		}
	}
	
	private static void killPort(Integer port) {
		// TODO Auto-generated method stub

		try {
			String cmd="cmd /c netstat -aon|findstr \""+port+"\"";
			Process p;
			p = Runtime.getRuntime().exec(cmd);
			InputStream inputStream = p.getInputStream();
			List<String> read = read(inputStream, "UTF-8");
		
			if(read.size() == 0){
				System.out.println("找不到该端口的进程");
				try {
					Thread.sleep(6000);
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				for (String string : read) {
					System.out.println(string);
				}
				System.out.println("找到"+read.size()+"个进程，正在准备清理");
				kill(read);
			}
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private static void kill(List<String> data) {
		// TODO Auto-generated method stub
		 Set<Integer> pids = new HashSet<>();
		 for (String line : data) {
			 int offset = line.lastIndexOf(" ");
			 String spid = line.substring(offset);
			 spid = spid.replaceAll(" ", "");
			 int pid = 0;
			 try {
				 pid = Integer.parseInt(spid);
			 } catch (NumberFormatException e) {
				 System.out.println("获取的进程号错误:" + spid);
			 }
			 pids.add(pid);
		 }
		 killWithPid(pids);
	}

	private static void killWithPid(Set<Integer> pids) {
		// TODO Auto-generated method stub
		for (Integer pid : pids) {
            try {
                Process process = Runtime.getRuntime().exec("taskkill /F /pid "+pid+"");
                InputStream inputStream = process.getInputStream();
                String txt = readTxt(inputStream, "GBK");
                System.out.println(txt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

	private static String readTxt(InputStream inputStream, String charset) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
        StringBuffer sb = new StringBuffer();
        String line;
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        reader.close();
        return sb.toString();
	}

	private static List<String> read(InputStream inputStream, String charset) throws IOException {
		// TODO Auto-generated method stub
		 List<String> data = new ArrayList<>();
		 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
		 String line;
		 System.out.println("@@@");
		 while((line = reader.readLine()) != null){
			 System.out.println("###");
			 System.out.println(line);
			 boolean validPort = validPort(line);
			 if(validPort){
				 data.add(line);
			 }
		 }
		 reader.close();
		 return data;
	}

	private static boolean validPort(String str) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("^ *[a-zA-Z]+ +\\S+");
        Matcher matcher = pattern.matcher(str);

        matcher.find();
        String find = matcher.group();
        int spstart = find.lastIndexOf(":");
        find = find.substring(spstart + 1);
        
        int port = 0;
        try {
            port = Integer.parseInt(find);
        } catch (NumberFormatException e) {
            System.out.println("查找到错误的端口:" + find);
            return false;
        }
        if(ports.contains(port)){
            return true;
        }else{
            return false;
        }
	}

}
