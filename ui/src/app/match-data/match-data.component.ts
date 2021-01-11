import { NgForOf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { IMatch } from '../match.type';
import { PostService } from '../post-service/post.service';

@Component({
  selector: 'app-match-data',
  templateUrl: './match-data.component.html',
  styleUrls: ['./match-data.component.css']
})

export class MatchDataComponent {

  matchList:IMatch[] = []

  constructor(private postService: PostService){}

  ngOnInit() {
    this.getAllMatches();
  }

  search(){
    var day = parseInt((document.getElementById("day") as HTMLInputElement).value);
    var month = parseInt((document.getElementById("month") as HTMLInputElement).value);
    var year = parseInt((document.getElementById("year") as HTMLInputElement).value);
    var result = this.matchList.filter(obj => {
      return obj.date.day === day &&
      obj.date.month === month &&
      obj.date.year === year
    })
    this.matchList = result
  }

  clear(){
    (document.getElementById("day") as HTMLInputElement).value = "";
    (document.getElementById("month") as HTMLInputElement).value = "";
    (document.getElementById("year") as HTMLInputElement).value = "";
    this.getAllMatches();
  }

  async getAllMatches(){
    try{
      const matches = await this.postService.getMatches().toPromise()
      this.matchList = matches;
    } catch(error){
      console.log(`[ERROR] getAllMatches => ${error.message}`, error);
    };
  }

  async generateMatch(){
    try{
      const matches = await this.postService.generate().toPromise()
      this.matchList = matches;
    } catch(error){
      console.log(`[ERROR] generateMatch => ${error.message}`, error);
    };
    this.getAllMatches();
  }


}
