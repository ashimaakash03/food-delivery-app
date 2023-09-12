import {Component, OnInit} from '@angular/core';
import {FoodItem} from "../../models/food-item";
import {FoodService} from "../../services/food.service";


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
	foods: FoodItem[] = []

	constructor(private foodService: FoodService) {
    }

    ngOnInit(): void {
		// @ts-ignore
		this.foods = this.foodService.getAll().subscribe(
			(data: FoodItem[]) => {
				this.foods = data;
				alert("Menu List Fetched");
			});
    }
}
