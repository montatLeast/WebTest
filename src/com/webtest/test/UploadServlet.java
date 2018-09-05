package com.webtest.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import bean.PersonalService;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // �ϴ�����
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	        // ����Ƿ�Ϊ��ý���ϴ�
	        if (!ServletFileUpload.isMultipartContent(request)) {
	            // ���������ֹͣ
	            PrintWriter writer = response.getWriter();
	            writer.println("Error: ��������� enctype=multipart/form-data");
	            writer.flush();
	            return;
	        }
	 
	        // �����ϴ�����
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // ������ʱ�洢Ŀ¼
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	        ServletFileUpload upload = new ServletFileUpload(factory);
	         
	        // ��������ļ��ϴ�ֵ
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	         
	        // �����������ֵ (�����ļ��ͱ�����)
	        upload.setSizeMax(MAX_REQUEST_SIZE);

	        // ���Ĵ���
	        upload.setHeaderEncoding("UTF-8"); 

	        // ������ʱ·�����洢�ϴ����ļ�
	        // ���·����Ե�ǰӦ�õ�Ŀ¼
	        //String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
	        String uploadPath ="img";
	        String absolutePath = "D:\\JavaTest\\WebTest\\WebContent\\img";
	        System.out.println(uploadPath);
	         
	        // ���Ŀ¼�������򴴽�
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	 
	        try {
	            // ���������������ȡ�ļ�����
	            @SuppressWarnings("unchecked")
	            List<FileItem> formItems = upload.parseRequest(new ServletRequestContext(request));
	 
	            if (formItems != null && formItems.size() > 0) {
	                // ����������
	                for (FileItem item : formItems) {
	                    // �����ڱ��е��ֶ�
	                    if (!item.isFormField()) {
	                        String fileName = new File(item.getName()).getName();
	                       //���·��
	                        String filePath = uploadPath + File.separator + fileName;
	                        //����·��
	                        String fileAbsoPath = absolutePath + File.separator + fileName;
	                        
	                        File storeFile = new File(fileAbsoPath);
	                        // �ڿ���̨����ļ����ϴ�·��
	                        System.out.println(fileAbsoPath);
	                        // �����ļ���Ӳ��
	                        item.write(storeFile);
	                        request.setAttribute("message",
	                            "�ļ��ϴ��ɹ�!");
	                        
	        	            PersonalService pser = new PersonalService();
	        	            String usr = (String)request.getSession().getAttribute("account");
	        	            
	        	            if(pser.updatePhoto(usr, filePath)) {
	        	    			response.sendRedirect("index.jsp");	
	        	            }
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            request.setAttribute("message",
	                    "������Ϣ: " + ex.getMessage());
	        }
	}

}
