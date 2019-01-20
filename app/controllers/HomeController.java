package controllers;

import models.City;
import models.Country;
import models.User;
import models.compoundKeys.Address;
import models.ghosts.CityGhost;
import models.ghosts.UserGhost;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    private final FormFactory formFactory;

    @Inject
    public HomeController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result home() { return ok(home.render());}
    public Result login() {return ok(login.render());}
    /**
     * Display the 'new city form'.
     */
    public Result blankCity(){
        Form<CityGhost> cityForm = formFactory.form(CityGhost.class);
        // Run companies db operation and then render the form
        return ok(views.html.forms.cityFormNew.render(cityForm));
    }
    public Result addCity() {
        Form<CityGhost> cityForm = formFactory.form(CityGhost.class).bindFromRequest();
        if (cityForm.hasErrors()) {
            // Run companies db operation and then render the form
            return badRequest(views.html.forms.cityFormNew.render(cityForm));
        }
	    CityGhost ghost = cityForm.get();
        // Run insert db operation, then redirect
	    City city = new City();
	    city.setEn(ghost.en);
	    city.setFr(ghost.fr);
	    city.setCountry(Country.find.byId(Long.parseLong(ghost.country)));
        city.save();
        flash("success", "The city " + city.getEn() + ", in " + city.getCountry().getEn() + ", has been created");
        return home();
    }

    /**
     * Display the 'new country form'.
     */
    public Result blankCountry() {
        Form<Country> countryForm = formFactory.form(Country.class);
        // Run companies db operation and then render the form
        return ok(views.html.forms.countryFormNew.render(countryForm));
    }

    public Result addCountry() {
        Form<Country> countryForm = formFactory.form(Country.class).bindFromRequest();
        if (countryForm.hasErrors()) {
            // Run companies db operation and then render the form
            return badRequest(views.html.forms.countryFormNew.render(countryForm));
        }
        Country country = countryForm.get();
        // Run insert db operation, then redirect
        country.save();
        flash("success", "The country " + country.getEn() + " has been created");
        return home();
    }

	/**
	 * Display the 'new city form'.
	 */
	public Result blankUser() {
		Form<UserGhost> userForm = formFactory.form(UserGhost.class);
		// Run companies db operation and then render the form
		return ok(views.html.forms.userFormNew.render(userForm));
	}

	public Result addUser() {
		Form<UserGhost> userForm = formFactory.form(UserGhost.class).bindFromRequest();
		if (userForm.hasErrors()) {
			// Run companies db operation and then render the form
			return badRequest(views.html.forms.userFormNew.render(userForm));
		}
		UserGhost ghost = userForm.get();
		if(ghost.password==null || !ghost.password.equals(ghost.password2))
			return badRequest(views.html.forms.userFormNew.render(userForm));
		// Run insert db operation, then redirect
		//return ok(play.twirl.api.Html.apply(ghost.toString()));
		User user = new User();
		user.setFirstName(ghost.firstName);
		user.setPassword(ghost.password);
		user.setLastName(ghost.lastName);
		user.setEmail(ghost.email);
		user.setPhoneNumber(ghost.phoneNumber);
		user.setDob(ghost.dob);
		user.setMob(ghost.mob);
		user.setYob(ghost.yob);
		user.setAddress(new Address(ghost.number, ghost.unit, ghost.street, ghost.postalCode, ghost.province, ghost.city, ghost.country));
		user.save();
		flash("success", "The user " + ghost.firstName + " " + ghost.lastName + ", has been created");
		return home();
	}

    public Result listCities(){return ok(views.html.lists.cityList.render());}
    public Result listCountries(){return ok(views.html.lists.countryList.render());}
    public Result listUsers(){return ok(views.html.lists.userList.render());}
    public Result getInfo(String id){
		User u = User.find.byId(id);
		return ok(play.twirl.api.Html.apply(u.getQR() + "<img href=\"assets/img/faces/" + u.getLastName() + "_" + u.getFirstName()) + ".jpg\">");
    }
}
