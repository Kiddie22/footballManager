import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { JSONTableModule } from 'angular-json-table';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PostService } from './post-service/post.service';
import { HeaderComponent } from './header/header.component';
import { TableComponent } from './club-data/table.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatchDataComponent } from './match-data/match-data.component';
import { WelcomeComponent } from './welcome/welcome.component';

@NgModule({
  declarations: [								
    AppComponent,
      HeaderComponent,
      TableComponent,
      MatchDataComponent,
      WelcomeComponent,
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    JSONTableModule,
    BrowserAnimationsModule,
  ],
  providers: [
    PostService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
