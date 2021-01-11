import { Component } from '@angular/core';
import { AppComponent } from '../app.component';
import { IClub } from '../club.type';
import { PostService } from '../post-service/post.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',  
  styleUrls: ['./table.component.scss']
})

export class TableComponent {

  clubsList: IClub[] = [];

  constructor(private postService: PostService){}

  ngOnInit(){
    this.getAllClubs();
  }

  sortByWins(a: IClub, b:IClub){
    if ( a.wins < b.wins ){
      return 1;
    }
    if ( a.wins > b.wins ){
      return -1;
    }
    return 0;
  }

  sortByPoints(a: IClub, b:IClub){
    if ( a.points < b.points ){
      return 1;
    }
    if ( a.points > b.points ){
      return -1;
    }
    return 0;
  }

  sortByGoals(a: IClub, b:IClub){
    if ( a.goalDifference < b.goalDifference ){
      return 1;
    }
    if ( a.goalDifference > b.goalDifference ){
      return -1;
    }
    return 0;
  }

  sortBy(index: any){
    if(index === 0){
      this.clubsList.sort(this.sortByPoints)
    }
    else if(index === 1){
      this.clubsList.sort(this.sortByWins)
    }
    else if(index === 2){
      this.clubsList.sort(this.sortByGoals)
    }
  }

  async getAllClubs(){
    try{
      const clubs = await this.postService.getClubs().toPromise()
      this.clubsList = clubs;
    } catch(error){
      console.log(`[ERROR] getAllPosts => ${error.message}`, error);
    };
  }
}