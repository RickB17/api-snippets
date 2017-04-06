using Newtonsoft.Json;
using System;
using System.Linq;
using System.Threading.Tasks;
using System.Web.Mvc;
using TwilioFax.Web.Infrastructure;
using TwilioFax.Web.Models;
using TwilioFax.Web.Services;
using Twilio;
using Twilio.AspNet.Mvc;
using Twilio.Rest.Api.V2010.Account;
using Twilio.Types;

namespace TwilioFax.Web.Controllers
{
    public class FaxController : TwilioController
    {

        public FaxController()
        {
            if (Config.ENV != "test")
            {
                TwilioClient.Init(Config.AccountSID, Config.AuthToken);
            }
        }

        [HttpPost]
        public ActionResult Recieved()
        {

        }
    }
}
