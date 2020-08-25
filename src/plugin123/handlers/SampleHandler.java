package plugin123.handlers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;
//import org.eclipse.core.filesystem.IFileStore;

public class SampleHandler extends AbstractHandler {
	 private final Random random = new Random();
	 private static final String CHARSFORCREATION = "abcdefghijklmnopqrstuvwxyz";
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		 IWorkspace workspace = ResourcesPlugin.getWorkspace();
	        IWorkspaceRoot root = workspace.getRoot();
	        IProject project = root.getProject("ProjH1");
	        try {
	            //project.create(new NullProgressMonitor());
	            project.open(null);
	            IFolder folderSrc = project.getFolder("src");
	            File sourceEsapi= new File("/home/vijay/sofftwresDownloaded/esapi-2.0.1.jar");
	            IFile destEsapi = project.getFolder("WebContent/WEB-INF/lib").getFile("esapi.jar");
	            destEsapi.create(new FileInputStream(sourceEsapi), IResource.NONE, null);
	            //IFile file2= folderSrc.getFile("");
	           // file2.create(new ByteArrayInputStream(createBytes(5000)), IResource.NONE, null);
	            /*
	             * 1) add esapi.jar http://www.java2s.com/Code/Jar/e/Downloadesapi201jar.htm
	             * 2) web.xml modify
	             * 3) place filter java code into src folder.
	             * 4) place esapi.properties.
	             */
	            File filter1 = new File("/home/vijay/sofftwresDownloaded/XSSFilter.java");
	            File wrapper1 = new File("/home/vijay/sofftwresDownloaded/XSSRequestWrapper.java");
	            IFile destWFilter=folderSrc.getFile("XSSFilter.java");
	            destWFilter.create(new FileInputStream(filter1), IResource.NONE, null);
	            IFile destWarapper = folderSrc.getFile("XSSRequestWrapper.java");
	            destWarapper.create(new FileInputStream(wrapper1), IResource.NONE, null);
	            }
	        catch (CoreException e) {
	            // nothing to do
	        } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	private byte[] createBytes(int length) {
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return bytes;
    }

    private String createString(int length) {
        StringBuilder buf = new StringBuilder(length);
        // fill the string with random characters up to the desired length
        for (int i = 0; i < length; i++) {
            buf.append(CHARSFORCREATION.charAt(random.nextInt(CHARSFORCREATION.length())));
        }
        return buf.toString();
    }

}
