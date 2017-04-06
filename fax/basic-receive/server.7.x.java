import static spark.Spark.get;

public class IndexFax {

    faxSent = (req, res) -> {
        // Let's manually build some TwiML. We can choose to receive the
        // fax with <Receive>, or reject with <Reject>.
        const twiml = "
            <Response>
                <Receive action="/fax/received"/>
            </Response>
        ";

        // Send Fax twiml response
        res.type("text/xml");
        res.body(twiml);
    };

    // Define a handler for when the fax is finished sending to us - if successful,
    // We will have a URL to the contents of the fax at this point
    faxReceived = (req, res) -> {
        // log the URL of the PDF received in the fax
        System.out.println(request.params(":mediaUrl"));

        // Respond with empty 200/OK to Twilio
        return response.status(200)
    };

    public static void main(String[] args) {
        post('/fax/sent', faxSent);
        post('/fax/received', faxReceived);
    }
}
