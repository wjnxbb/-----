package javaweb2;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Response {
	private static final int size=1024;
	Request request;
	OutputStream output;
	
	public Response(OutputStream output){
		this.output=output;
	}
	
	public void setRequest(Request request){
		this.request=request;
	}
	
	public void sendStaticResource()throws IOException{
		byte[] bytes=new byte[size];
		FileInputStream fis=null;
		try {
			File file=new File(HttpServer.root,request.getUri());
			if(file.exists()){
				fis=new FileInputStream(file);
				int ch=fis.read(bytes,0,size);
				while(ch!=-1){
					output.write(bytes, 0, size);
					ch=fis.read(bytes, 0, size);
				}
			}else{
				//file not found
				String errorMessage="HTTP/1.1 404 File Not Found\r\n"+
				"Content-Type:text/html\r\n"+
				"Content-Length:23\r\n"+
				"\r\n"+
				"<h1>File Not Found</h1>";
				output.write(errorMessage.getBytes());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally{
			if(fis!=null){
				fis.close();
			}
		}
	}
}

