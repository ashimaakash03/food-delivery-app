import {Restaurant} from './restaurant';

describe('Restaurant', () => {
	it('should create an instance', () => {
		expect(new Restaurant(0, "", "", 0, [], "", "")).toBeTruthy();
	});
});
