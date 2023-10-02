import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Customer} from "../../models/customer";

@Component({
	selector: 'app-login', templateUrl: './login.component.html', styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	baseUrl: string = "http://localhost:3004/customers-list";
	loginForm: FormGroup

	constructor(private formBuilderService: FormBuilder, private http: HttpClient, private router: Router) {
		this.loginForm = this.formBuilderService.group({
			// fullname: ['', [Validators.required, Validators.maxLength(50)]],
			// contact: ['', [Validators.required, Validators.pattern('^[6-9]\\d{9}$')]],
			email: ['', [Validators.required, Validators.email]],
			password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]]
		})
	}

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

	// login(data: Customer) {
	// 	this.httpClient.post('http://localhost:8081/home/login', data)
	// 		.subscribe((result: any) => {
	// 			this.router.navigate(['/home'])
	// 			this.snackBar.open('Logged in Successfully', 'Close', {
	// 				duration: 2000
	// 			});
	// 		}, (error: HttpErrorResponse) => {
	// 			if (error.status === 404) {
	// 				this.snackBar.open('Error: ' + error.error.message, 'Close', {
	// 					duration: 3000
	// 				});
	// 			} else if (error.status === 401) {
	// 				this.snackBar.open('Error: ' + error.error.message, 'Close', {
	// 					duration: 3000
	// 				});
	// 			} else {
	// 				console.error('Error: ', error);
	// 			}
	// 		});
	// }
	//
	// customerLogin(data: Customer) {
	// 	this.login(data)
	// }

	loginCustomer() {
		this.http.get<Array<Customer>>(this.baseUrl).subscribe((result) => {
			// @ts-ignore
			const user: Customer = result.filter((person: Customer) => {
				return person.email === this.loginForm.value.email && person.password === this.loginForm.value.password;
			})
			if (user) {
				alert(" Login successful !!! ");
				this.loginForm.reset();
				this.router.navigateByUrl("/home");
			}
		})
	}
}
