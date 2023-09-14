import {Component, OnInit} from '@angular/core';
import {RestaurantService} from "../../services/restaurant.service";
import {Restaurant} from "../../models/restaurant";


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
	restaurants: Restaurant[] = [];

	constructor(private restaurantService: RestaurantService) {
	}
    ngOnInit(): void {
		// @ts-ignore
		this.restaurants = this.restaurantService.getAll().subscribe(
			(data: Restaurant[]) => {
				this.restaurants = data;
				alert("List of Restaurants Fetched");
			}
		)
	}

}
