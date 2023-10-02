import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Customer} from "../../models/customer";

@Component({
	selector: 'app-register', templateUrl: './register.component.html', styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

	baseUrl: string = "http://localhost:3004/customers-list";
	registerForm: FormGroup;
	cities: string[] = ['Mumbai', 'Delhi', 'Bangalore', 'Hyderabad', 'Pune', 'Chennai', 'Jaipur', 'Chandigarh', 'Mysore', 'Noida']

	constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router) {
		this.registerForm = this.formBuilder.group({
			fullname: ['', [Validators.required, Validators.maxLength(50)]],
			contact: ['', [Validators.required, Validators.pattern('^[6-9]\\d{9}$')]],
			email: ['', [Validators.required, Validators.email]],
			password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]]
		});
	}

	// register() {
	// 	if (this.registerForm.invalid) {
	// 		return;
	// 	}
	//
	// 	const customer: Customer = {
	// 		fullname: this.registerForm.value.fullname,
	// 		contact: this.registerForm.value.contact,
	// 		email: this.registerForm.value.email,
	// 		password: this.registerForm.value.password
	// 	};
	//
	// 	const url = 'http://localhost:8081/home/register';
	// 	const httpOptions = {
	// 		headers: new HttpHeaders({
	// 			'Content-Type': 'application/json',
	// 		}),
	// 	};
	//
	// 	this.httpClient.post(url, customer, httpOptions)
	// 		.subscribe(() => {
	// 			this.snackBar.open('Registered Successfully✔️', 'Close', {
	// 				duration: 2000
	// 			});
	// 			this.router.navigate(['/login']);
	// 		}, (error: HttpErrorResponse) => {
	// 			if (error.status === 409) {
	// 				this.snackBar.open(error.error.message, 'Close', {
	// 					duration: 3000
	// 				});
	// 			} else {
	// 				console.error('Error: ', error);
	// 			}
	// 		});
	// }

	ngOnInit(): void {
		let form = document.querySelector('form') as HTMLFormElement;
		form.addEventListener('submit', (submitEvent: SubmitEvent) => {
			if (!form.checkValidity()) {
				submitEvent.preventDefault();
				submitEvent.stopPropagation();
			}
			form.classList.add('was-validated');
		});
	}

	registerCustomer() {

		const customer: Customer = {
			fullname: this.registerForm.value.fullname,
			contact: this.registerForm.value.contact,
			email: this.registerForm.value.email,
			password: this.registerForm.value.password
		};

		const httpOptions = {
			headers: new HttpHeaders({
				'Content-Type': 'application/json',
			}),
		};

		this.http.post<Customer>(this.baseUrl, customer, httpOptions).subscribe(() => {
			alert(customer.fullname + " Registered Successfully");
			this.registerForm.reset();
			this.router.navigateByUrl("/login");
		})
	}
}
