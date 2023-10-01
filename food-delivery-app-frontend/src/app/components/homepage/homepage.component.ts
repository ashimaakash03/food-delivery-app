import {Component, OnInit} from '@angular/core';
import {RestaurantService} from "../../services/restaurant.service";
import {Restaurant} from "../../models/restaurant";
import {MatSnackBar} from "@angular/material/snack-bar";


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
	restaurants: Restaurant[] = [];

	constructor(private restaurantService: RestaurantService, private snackbar: MatSnackBar) {
	}
    ngOnInit(): void {
		// @ts-ignore
		this.restaurants = this.restaurantService.getAll().subscribe(
			(data: Restaurant[]) => {
				this.restaurants = data;
				this.snackbar.open("List of Restaurants Fetched","OK",{
					duration: 3000, panelClass: ['mat-toolbar', 'blue']
				})
			}
		)
	}

}
