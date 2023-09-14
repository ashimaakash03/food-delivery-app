import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Restaurant} from "../models/restaurant";

@Injectable({
	providedIn: 'root'
})
export class RestaurantService {
	url: string = "http://localhost:3002/restaurants";

	constructor(private http: HttpClient) {
	}

	getAll(): Observable<Restaurant[]> {
		return this.http.get<Restaurant[]>(this.url);
	}
}
