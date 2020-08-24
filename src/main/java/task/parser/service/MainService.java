package task.parser.service;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import task.parser.exception.ParsingException;
import task.parser.service.parsing.Handler;

@Service
public class MainService implements CommandLineRunner {

	@Autowired
	List<Handler> listConverters;

	@Override
	public void run(String... args) {

		if (args.length == 0) {
			System.out.println("Wrong request!");
			return;
		}

		Iterator<String> iterator = Arrays.asList(args).iterator();
		
		List <String> filesPaths = new ArrayList<>();
		while (iterator.hasNext()) {
			
			String path = iterator.next();
			
			if (!Files.exists(Paths.get(path))) {
				try {
					throw new FileNotFoundException();
				} catch (Exception e) {
					System.out.println("ERROR: File " + path + " doesn't exists");
				}
			}else {
				filesPaths.add(path);
			}
		}
		
		 try {
		 filesPaths.stream().distinct().parallel().forEach(this::threatFileName); 
		 }
		 catch (Exception e) {
			 System.out.println(e.getMessage());
		 }
	}

	private void threatFileName(String filename) {
		String extension = filename.split("\\.")[1];

		boolean isExtension = listConverters.stream().anyMatch(c -> c.getFormatName().equals(extension));

		if (!isExtension) {
			System.out.println("ERROR: File format \"" + extension + "\" is not supported!");
		}
		listConverters.stream().filter(c -> c.getFormatName().equals(extension.trim()))
				.forEach(c -> c.converter(filename));
	}
}