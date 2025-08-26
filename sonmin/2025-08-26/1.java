package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RestController
    public static class ApiController {
        private final String DATA_DIR = "./data/input";
        private final ObjectMapper objectMapper = new ObjectMapper();

        @GetMapping("/api/gamerecord/users")
        // 여기에 코드를 작성하세요.
        public ResponseEntity<?> getUsers() {
            try {
                List<Map<String, Object>> users = objectMapper.readValue(
                        Files.readAllBytes(Paths.get(DATA_DIR, "records.json")),
                        new TypeReference<>() {
                        });
                List<Map<String, Object>> answers = new ArrayList<>();
                for(int i=0; i<users.size();i++)
                {
                    Map<String, Object> user = users.get(i);
                    String username = user.get("username").toString();
                    String tag = user.get("tag").toString();
                    Map<String, Object> answer = new HashMap<String,Object>();
                    answer.put("username",username);
                    answer.put("tag",tag);
                    answers.add(answer);
                }
                Collections.sort(answers, (o1, o2) -> {
                    String u1 = (String) o1.get("username");
                    String u2 = (String) o2.get("username");
                    if(u1.equals(u2))
                    {
                        String t1 = (String) o1.get("tag");
                        String t2 = (String) o2.get("tag");
                        return t1.compareTo(t2);
                    }
                    return u1.compareTo(u2); // 오름차순
                });
                return ResponseEntity.ok(answers);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @GetMapping("/api/gamerecord/winrate")
        // 여기에 코드를 작성하세요.
        public ResponseEntity<?> getWinrate(@RequestParam(required = false) String username, @RequestParam(required = false) String tag) {
            try {
                Map<String, String> error = new HashMap<>();
                error.put("error","Invalid data format");
                if(username==null||tag==null) return ResponseEntity.status(401).body(error);
                List<Map<String, Object>> users = objectMapper.readValue(
                        Files.readAllBytes(Paths.get(DATA_DIR, "records.json")),
                        new TypeReference<>() {
                        });
                for(int i=0;i<users.size();i++)
                {
                    Map<String,Object> user = users.get(i);
                    if(user.get(username)!=null)
                    {
                        if(user.get(tag)!=null)
                        {
                            int win = (int)user.get("win");
                            int lose = (int)user.get("lose");
                            System.out.println((int)win/(win+lose));
                            Map<String, Integer> map = new HashMap<>();
                            map.put("winrate", (int)win/(win+lose));
                            return ResponseEntity.ok(map);
                        }
                    }
                }
                Map<String, String> error2 = new HashMap<>();
                error2.put("error","data not found");
                System.out.println(users);
                return ResponseEntity.status(404).body(error2);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }
}
