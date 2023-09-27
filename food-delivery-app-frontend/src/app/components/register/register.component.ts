import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Customer} from "../../models/customer";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";

@Component({
	selector: 'app-register', templateUrl: './register.component.html', styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
	registerForm!: FormGroup;

	constructor(private formBuilder: FormBuilder, private httpClient: HttpClient, private snackBar: MatSnackBar, private router: Router) {
	}

	ngOnInit(): void {
		this.registerForm = this.formBuilder.group({
			fullname: ['', [Validators.required, Validators.maxLength(50)]],
			contact: ['', [Validators.required, Validators.pattern('^[6-9]\\d{9}$')]],
			email: ['', [Validators.required, Validators.email]],
			password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]]
		});
	}

	register() {
		if (this.registerForm.invalid) {
			return;
		}

		const customer: Customer = {
			fullname: this.registerForm.value.fullname,
			contact: this.registerForm.value.contact,
			email: this.registerForm.value.email,
			password: this.registerForm.value.password
		};

		const url = 'http://localhost:8081/home/register';
		const httpOptions = {
			headers: new HttpHeaders({
				'Content-Type': 'application/json',
			}),
		};

		this.httpClient.post(url, customer, httpOptions)
			.subscribe(() => {
				this.snackBar.open('Registered Successfully✔️', 'Close', {
					duration: 2000
				});
				this.router.navigate(['/login']);
			}, (error: HttpErrorResponse) => {
				if (error.status === 409) {
					this.snackBar.open(error.error.message, 'Close', {
						duration: 3000
					});
				} else {
					console.error('Error: ', error);
				}
			});
	}

	cities = [
		{name: 'Bangalore'},
		{name: 'Mumbai'},
		{name: 'Delhi'},
		{name: 'Hyderabad'},
		{name: 'Pune'},
		{name: 'Chennai'},
		{name: 'Jaipur'},
		{name: 'Chandigarh'},
		{name: 'Mysore'},
		{name: ''},
	]
}
