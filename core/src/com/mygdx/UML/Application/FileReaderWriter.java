package com.mygdx.UML.Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import UI.UMLComponent;

public class FileReaderWriter
{
	public static boolean saveFile(ArrayList<UMLComponent> uml)
	{

		String fileName = "save.sav";
		try
		{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("<start>\n");

			for (UMLComponent u : uml)
			{
				bufferedWriter.write(u.toString());
			}
			bufferedWriter.write("<end>");
			bufferedWriter.close();
			return true;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.print("Error Writing to file " + fileName + " error " + e);
			return false;
		}

	}

	public static ArrayList<String> load()
	{

		ArrayList<String> components = new ArrayList<String>();
		String fileName = "save.sav";
		try
		{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while ((line = bufferedReader.readLine()) != null)
			{
				line.trim();
				if (line.equals("<start>"))
				{
					continue;
				}
				if (line.equals("<end>"))
				{
					break;
				}

				if (line.equals("<State>"))
				{
					String attributes = " state \n";
					while (!(line = bufferedReader.readLine()).equals("</State>"))
					{
						System.out.println(" line " + line);
						attributes = attributes + line + "\n";
					}

					System.out.println("Read from file" + attributes);
					components.add(attributes);
				} else if (line.equals("<Transition>"))
				{
					String attributes = " Transition \n";
					while (!(line = bufferedReader.readLine()).equals("</Transition>"))
					{
						System.out.println(" line " + line);
						attributes = attributes + line + "\n";
					}

					System.out.println("Read from file" + attributes);
					components.add(attributes);
				}

			}
			bufferedReader.close();
			return components;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.print("Error Writing to file " + fileName + " error " + e);
			return components;
		}

	}

}
