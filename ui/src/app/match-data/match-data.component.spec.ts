/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { MatchDataComponent } from './match-data.component';

describe('MatchDataComponent', () => {
  let component: MatchDataComponent;
  let fixture: ComponentFixture<MatchDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MatchDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
