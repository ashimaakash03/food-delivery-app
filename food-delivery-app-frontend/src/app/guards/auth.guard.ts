import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";

export const authGuard: CanActivateFn = (route, state) => {

	let router = inject(Router);
	let result: boolean = false;
	let isLoggedIn = localStorage.getItem("isLoggeedIn");

	if (isLoggedIn === "false") {
		alert("User Not Logged In. Please Login to continue");
		router.navigateByUrl("/login")
		result = false;
	} else {
		result = true;
	}
	return result;
};
