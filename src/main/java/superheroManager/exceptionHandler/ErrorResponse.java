package superheroManager.exceptionHandler;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "error")
public class ErrorResponse
{
    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    private String message;
    private List<String> details;
//    private timestamp
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }
//  "timestamp": "2021-03-11T23:34:03.202+00:00",
//          "status": 403,
//          "error": "Forbidden",
//          "message": "",
//          "path": "/deleteHero"
    public void setDetails(List<String> details) {
        this.details = details;
    }
}