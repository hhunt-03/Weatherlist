import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectedLocationComponent } from './selected-location.component';

describe('SelectedLocationComponent', () => {
  let component: SelectedLocationComponent;
  let fixture: ComponentFixture<SelectedLocationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectedLocationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectedLocationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
