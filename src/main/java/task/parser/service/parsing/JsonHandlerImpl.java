package task.parser.service.parsing;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import task.parser.model.Extension;
import task.parser.model.InputModel;

@Service
public class JsonHandlerImpl implements Handler {

	public static final ObjectMapper MAPPER = new ObjectMapper();

	@Override
	public void converter(String filePath) {
		try {
			List<InputModel> inputModels = Arrays.asList(MAPPER.readValue(new File(filePath), InputModel[].class));

			IntStream
			.range(0, inputModels.size())
			.forEach(i -> createOutput(inputModels.get(i), i + 1, filePath));
		} catch (IOException e) {
			System.out.println("JSON is not array!");
		}
	}

	@Override
	public String getFormatName() {
		return Extension.JSON.getNameLowerCase();
	}
}