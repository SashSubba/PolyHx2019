package models.finders;

import io.ebean.Finder;
import models.User;

public class UserFinder extends Finder<String, User> {
	public UserFinder(){super(User.class);}
}
