// package base.template.template.service;

// import base.template.template.api.model.Model;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileWriter;
// import java.util.Collections;

// import static org.mockito.Mockito.*;

// public class TemplateServiceTest {
//     //Testing the first Unit test of the saveToFile method from TemplateService
//     @Mock
//     private ObjectMapper objectMapper;

//     @InjectMocks
//     private TemplateService templateService;

//     @BeforeEach
//     public void setUp(){
//         MockitoAnnotations.openMocks(this); //Initiaalizes the mock
//     }

//     @Test
//     public void testSaveToFile() throws Exception{
//         //mock behavior of object mapper
//         when(objectMapper.writeValueAsString(any())).thenReturn("mocker_Json");

//         //create  a temporary file for testing
//         String filePath = "test-file.txt";
//         File testFile = new File("/tmp/" + filePath);

//         //Call the method under test
//         templateService.saveToFile(Collections.singletonList(new Model("data")), filePath);

//         //VErify that the file was created and contains the correct data
//         BufferedWriter writer = new BufferedWriter(new FileWriter(testFile));
//         writer.write("mocked_json\n");
//         writer.close();

//         //clean up after test
//         if (testFile.exists()){
//             testFile.delete();
//         }

//         //Verify the interaction
//         verify(objectMapper, times(1)).writeValueAsString(any());
//     }
// }
