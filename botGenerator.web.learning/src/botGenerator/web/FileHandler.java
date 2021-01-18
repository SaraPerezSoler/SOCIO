package botGenerator.web;

import java.io.IOException;

import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;

import com.google.inject.Inject;

public class FileHandler implements IServerResourceHandler {
	@Inject
	private IWebResourceSetProvider resourceSetProvide;
	
	@Override
	public XtextWebDocument get(String resourceId, IServiceContext serviceContext) throws IOException {
		
		return null;
	}

	@Override
	public void put(IXtextWebDocument document, IServiceContext serviceContext) throws IOException {
		// TODO Auto-generated method stub

	}

}
