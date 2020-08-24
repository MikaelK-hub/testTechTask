package task.parser.service.parsing;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import task.parser.model.Extension;
import task.parser.model.InputModel;

@Service
public class JsonHandlerImpl implements Handler {

	@Override
	public void converter(String filePath) {

		try {
			List<InputModel> inputModels = MAPPER
					.readValue(new File(filePath), new TypeReference<List<InputModel>>() {});

			IntStream
			.range(0, inputModels.size())
			.forEach(i -> createOutput(inputModels.get(i), i + 1, filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFormatName() {
		return Extension.JSON.getNameLowerCase();
	}
}