export class Restaurant {
	id: number;
	name: string;
	imageUrl: string;
	ratings: number;
	deliveryTime: string;

	constructor(id: number, name: string, imageUrl: string, ratings: number, deliveryTime: string) {
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.ratings = ratings;
		this.deliveryTime = deliveryTime;
	}
}
