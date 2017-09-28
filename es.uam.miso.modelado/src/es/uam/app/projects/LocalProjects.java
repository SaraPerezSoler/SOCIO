package es.uam.app.projects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeTableXYDataset;

import DslHistory.Constraint;
import es.uam.app.actions.ActionModel;
import es.uam.app.actions.Create;
import es.uam.app.actions.Update;
import es.uam.app.main.commands.History.Order;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.parser.SentencesSplitter;
import es.uam.app.parser.rules.ExtractionRule;
import es.uam.app.projects.ecore.Controlador;
import es.uam.app.projects.log.HistoryControl;
import es.uam.app.projects.log.RemoveLogControl;
import es.uam.app.uml.UML;
import projectHistory.Msg;
import socioProjects.SocioApp;
import socioProjects.Visibility;
import socioProjects.impl.ProjectImpl;

public abstract class LocalProjectsFalse extends ProjectImpl{

	protected final static String URI = "./projects";

	


	public abstract String FilePath();

	public abstract FileProject getFileProject();

	public abstract void setFileProject(FileProject fileProj);

	public abstract List<Controlador> getAllObjects();

	private void save() throws Exception {

		getFileProject().save();
		log.save();
		rlc.save();

	}

	public static File getProjectList() {
		String cad = "@startuml\n";
		for (Project p : proj) {
			ReceivedMessage msg = p.log.getCreateMsg();
			cad += "folder " + p.name + "[\n";
			cad += "creation date: " + msg.getDate() + "\n";
			cad += "----\n";
			cad += "creation by: " + msg.getUser().getName() + "\n";
			cad += "----\n";
			cad += "in: " + msg.getChannel() + "\n";
			cad += "]\n";
		}
		cad += "\n@enduml";
		File txt = UML.write(URI + "/ProjectsList.txt", cad);
		File png = UML.getUML(txt);
		return png;
	}

	public abstract String validate();



}
