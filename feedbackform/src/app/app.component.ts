import { Component } from '@angular/core';


import { MaterialModule } from './materialmodule';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [MaterialModule,ReactiveFormsModule,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'feedbackform';

  feedbackForm: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {
    console.log("Checking validations");
    this.feedbackForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      subject: ['', [Validators.required, Validators.maxLength(40)]],
      comments: ['', [Validators.maxLength(350)]]
    });
  }

  onSubmit() {
    if (this.feedbackForm.valid) {
      this.submitted = true;
      console.log('Form Data:', this.feedbackForm.value);
      this.feedbackForm.reset();
    }
  }
}
