import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  tabIndex = 0;

  onTabClick(index: any){
    this.tabIndex = index;
}

  constructor() { }

  ngOnInit() {
  }

}
