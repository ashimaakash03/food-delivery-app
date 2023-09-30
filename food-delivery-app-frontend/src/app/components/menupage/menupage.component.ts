import {Component, OnInit} from '@angular/core';
import {FoodItem} from "../../models/food-item";
import {FoodService} from "../../services/food.service";
import {CartService} from "../../services/cart.service";
import {Router} from "@angular/router";

@Component({
	selector: 'app-menupage', templateUrl: './menupage.component.html', styleUrls: ['./menupage.component.css']
})
export class MenupageComponent implements OnInit {
	menuitems: FoodItem[] = [];

	constructor(private foodService: FoodService, private cartService: CartService, private route: Router) {
	}

	ngOnInit(): void {
		// @ts-ignore
		this.menuitems = this.foodService.getAll().subscribe((data: FoodItem[]) => {
			this.menuitems = data;
			alert("Menu List Fetched");

			this.menuitems.forEach((item: FoodItem) => {
				Object.assign(item, {quantity: 1, cost: item.price});
			})
		});
	}

	addToCart(foodItem: FoodItem) {
		this.cartService.addToCart(foodItem);
		this.route.navigateByUrl("/cart");
	}
}
