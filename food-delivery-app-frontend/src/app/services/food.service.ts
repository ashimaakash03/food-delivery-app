import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FoodItem} from "../models/food-item";
import {Observable} from "rxjs";

@Injectable({
	providedIn: 'root'
})
export class FoodService {
	url: string = "http://localhost:3000/menu-list";

	constructor(private http: HttpClient) {
	}

	getAll(): Observable<FoodItem[]> {
		return this.http.get<FoodItem[]>(this.url);
	}
}
