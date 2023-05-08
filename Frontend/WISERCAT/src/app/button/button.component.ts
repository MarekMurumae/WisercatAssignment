import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-button',
  template: '<button class="btn btn-primary btn-lg btn-block my-2" (click)="navigate()">{{ buttonText }}</button>'
})
export class ButtonComponent {
  @Input() buttonText: string;
  @Input() destinationUrl: string;

  constructor(private router: Router) {
    this.buttonText = "My Pets"
    this.destinationUrl = ""
  }

  navigate(): void {
    this.router.navigateByUrl(this.destinationUrl);
  }
}

