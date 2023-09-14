import {Component, OnInit} from '@angular/core';
import {FoodItem} from "../../models/food-item";
import {FoodService} from "../../services/food.service";

@Component({
	selector: 'app-menupage',
	templateUrl: './menupage.component.html',
	styleUrls: ['./menupage.component.css']
})
export class MenupageComponent implements OnInit {
	menuitems: FoodItem[] = [];

	constructor(private foodService: FoodService) {
	}
	ngOnInit(): void {
		// @ts-ignore
		this.menuitems = this.foodService.getAll().subscribe(
			(data: FoodItem[]) => {
				this.menuitems = data;
				alert("Menu List Fetched");
			}
		);
	}

}
