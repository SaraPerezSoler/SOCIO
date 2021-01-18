import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xtext.botGenerator.BotStandaloneSetup;

import com.google.inject.Injector;

import dialogflow.agent.Agent;
import dialogflow.agent.AgentToBot;
import dialogflow.agent.ReadAgent;
import generator.Bot;
import generator.GeneratorPackage;

public class Test {
	
	private static String path ="D:\\Desktop\\chatbots-20200528T121437Z-001\\chatbots\\";

	private static String name = "viberSampleNutrition";
	public static void main(String[] args) throws IOException {
		File zip = new File(
				path + name +".zip");
		Agent agent = new ReadAgent().getAgent(zip);
		Bot bot = new AgentToBot ().getBot(agent);
		ModelToDsl(bot, name+".bot");
		System.out.println("Total classes:"+CountClassBot(bot));
	}

	public static void ModelToDsl(Bot bot, String outputUri) {
	    init();


	    // Create new target file
	    Injector injector = new BotStandaloneSetup().createInjectorAndDoEMFRegistration();
	    XtextResourceSet resourceSetXtext = injector.getInstance(XtextResourceSet.class);
	   resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	    Resource resourceDsl = resourceSetXtext.createResource(URI.createURI(outputUri));

	    // Copy content
	    resourceDsl.getContents().add(bot);
	    
	    try {
	      resourceDsl.save(Collections.emptyMap());
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	
	public static void init() {
	    new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");

	    // Register respective language(s)
	    if (!EPackage.Registry.INSTANCE.containsKey(GeneratorPackage.eNS_URI)) {
	      EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
	    }
	  }
	public static int CountClassBot(EObject bot) {
		 // Create an empty list 
        List<EObject> list = new ArrayList<>(); 
  
        // Add each element of iterator to the List 
        bot.eAllContents().forEachRemaining(list::add); 
		
		return list.size();
	}
	
}
