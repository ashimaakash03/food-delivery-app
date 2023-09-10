export class Customer {
	fullname: string;
	contact: string;
	email: string;
	password: string;

	constructor(fullname: string, contact: string, email: string, password: string) {
		this.fullname = fullname;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}
}
