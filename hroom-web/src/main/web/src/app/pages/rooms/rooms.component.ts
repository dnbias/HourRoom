import {Component, OnInit} from '@angular/core';
import {InsertionService} from "../../service/insertion/insertion.service"
import {FormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {insertion} from "../../shared/models/insertion";
import { ToastrService } from 'ngx-toastr'

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrl: './rooms.component.css'
})

export class RoomsComponent implements OnInit{

  insertionList:any[]=[];
  insertionData : insertion={
    insertion_type: 'room',
    id: 0,
    landlordId: 1,
    name: '',
    tags: [],
    description: [''],
    price: 0,
    city: '',
    address: '',
    area: 0,
    photoIds: [],
    rating: 0,
    receivedFeedbacksIds: [],
    availabilityId: 0,
  }
  resetCamp(id:number){
    this.svc.deleteInsertion(id).subscribe((res:any)=>{
      this.insertionList=[];
    });
  }

  addRoom(){}

  constructor(private svc: InsertionService,
              private toastr: ToastrService,
              private http: HttpClient) {

  }
  newUri='';

  ngOnInit(): void {
    // this.getAllRooms();
    this.testPhotoUpload();
  }

  getAllRooms() {
    // this.roomSrv.getAllRooms().subscribe((res:any)=>{
    this.svc.fetchInsertionList().subscribe((res:any)=>{
      this.insertionList = res.data;
    })
  }

  saveRooms() {
    // TODO allineare tabella con i dati in src/app/shared/models/insertion.ts
  this.insertionList.forEach(item=>
  {
    this.svc.saveInsertion(item).subscribe((res:any) => {
      if(res.result){
        alert('upload success');
        console.log(res);
        this.toastr.success('OK','Insertions Uploaded')
      }
      else alert(res.message)

    })
  })

   }

  AddNewRoom() {
    const obj = {
        insertion_type: 'room',
        id: 0,
        landlordId: 1,
        name: '',
        tags: [],
        description: [''],
        price: 0,
        city: '',
        address: '',
        area: 0,
        photoIds: [],
        rating: 0,
        receivedFeedbacksIds: [],
        availabilityId: 0,
    }
    this.insertionList.unshift(obj)
  }



  onDelete(id: number) {
    this.svc.deleteInsertion(id).subscribe((res:any)=>{
      if(res.status == 200 || res.status == 201) {
        alert('Room Deleted Success');
        this.getAllRooms();
      } else {
        alert(res.message)
      }
    })
  }

  uploadPhoto(photo: any) {
    // var data = photoFile.arrayBuffer;
    this.svc.uploadPhoto(photo).subscribe((res: Response) => {
      console.log(res);
      if (res.status == 200 || res.status == 201) {
        this.newUri = new String(res.body).toString();
        this.toastr.success('OK','Photo Uploaded');
      } else {
        this.toastr.error('ERROR: '+res.status,
          'Photo Upload failed');
      }
    });
  }

  testPhotoUpload() {
    console.log('Testing upload w/ test.png')
    this.http.get('assets/images/test.png', { responseType: 'blob' })
      .subscribe(res => {
        this.uploadPhoto(res);
      });
  }


}
