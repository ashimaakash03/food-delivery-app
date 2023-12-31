import {FoodItem} from "./food-item";

export class Restaurant {
	id: number;
	name: string;
	imageUrl: string;
	ratings: number;
	menu: FoodItem[];
	deliveryTime: string;
	city: string;

	constructor(id: number, name: string, imageUrl: string, ratings: number, menu: FoodItem[], deliveryTime: string, city: string) {
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.ratings = ratings;
		this.menu = menu;
		this.deliveryTime = deliveryTime;
		this.city = city;
	}
}
