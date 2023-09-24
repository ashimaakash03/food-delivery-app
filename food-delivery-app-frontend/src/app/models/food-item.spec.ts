import {FoodItem} from './food-item';

describe('FoodItem', () => {
	it('should create an instance', () => {
		expect(new FoodItem(0, "", "", "", 0, 0, 0)).toBeTruthy();
	});
});
