#!/usr/bin/env python

from flask import Response, request

"""
Define a handler for when the fax is initially sent
"""
@app.route('/fax/sent', methods=['POST'])
def fax_sent():
    # Let's manually build some TwiML. We can choose to receive the
    # fax with <Receive>, or reject with <Reject>.
    twiml = """
        <Response>
            <Receive action="/fax/received"/>
        </Response>
    """;

    return Response(twiml, mimetype='text/xml')


"""
Define a handler for when the fax is finished sending to us - if successful,
We will have a URL to the contents of the fax at this point
"""
@app.route('/fax/received', methods=['POST'])
def fax_received():
  # log the URL of the PDF received in the fax
  app.logger.info(request.form.get('MediaUrl'))

  # Respond with empty 200/OK to Twilio
  return '', 200
