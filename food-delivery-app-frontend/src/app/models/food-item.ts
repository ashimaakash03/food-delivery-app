export class FoodItem {
	id: number;
	name: string;
	category: string;
	imageUrl: string;
	price: number;
	ratings: number;
	isFavourite: boolean;

	constructor(id: number, name: string, category: string, imageUrl: string, price: number, ratings: number, isFavourite: boolean) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.imageUrl = imageUrl;
		this.price = price;
		this.ratings = ratings;
		this.isFavourite = isFavourite;
	}
}
