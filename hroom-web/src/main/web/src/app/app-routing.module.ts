import { RouterModule, Routes } from '@angular/router';
import { StanzeComponent } from './pages/stanze/stanze.component';
import { ErrorComponent } from './pages/error/error.component';
import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import {LogoutComponent} from "./pages/logout/logout.component";
import {RouteGuardService} from "../services/routeGuardService";
import {GridStanzeComponent} from "./pages/grid-stanze/grid-stanze.component";
import {RegistrazioneComponent} from "./pages/registrazione/registrazione.component";
import {NotificationsComponent} from "./core/notifications/notifications.component";
import {HomeComponent} from "./pages/home/home.component";
import {LoggoogleComponent} from "./pages/loggoogle/loggoogle.component";
import {NewBookingComponent} from "./pages/new-booking/new-booking.component";
import {StanzaPageComponent} from "./pages/stanza-page/stanza-page.component";
import {CartPageComponent} from "./pages/cart-page/cart-page.component";
import {FeedbackComponent} from "./pages/welcome/Componenti-welcome/feedback/feedback.component";
import {PortfolioComponent} from "./pages/welcome/Componenti-welcome/portfolio/portfolio.component";
import {StanzeAffitateComponent} from "./pages/welcome/Componenti-welcome/stanze-affitate/stanze-affitate.component";
import {PrenotazioniComponent} from "./pages/welcome/Componenti-welcome/prenotazioni/prenotazioni.component";
import {NavComponent} from "./core/nav/nav.component";

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'registrazione',component:RegistrazioneComponent},
  {path:'welcome/:userid', component: WelcomeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze', component: StanzeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze/grid', component: GridStanzeComponent,canActivate:[RouteGuardService]},
  {path:'logout', component : LogoutComponent,canActivate:[RouteGuardService]},
  {path:'home',component:HomeComponent},
  {path:'loggoogle',component:LoggoogleComponent,canActivate:[RouteGuardService]},
  {path:'booking',component:NewBookingComponent,canActivate:[RouteGuardService]},
  {path:'search/:searchItem',component:HomeComponent},
  {path:'tag/:tag',component:HomeComponent},
  {path:'stanza/:id',component:StanzaPageComponent},
  {path: 'cart-page',component:CartPageComponent},
  {path:'feedback',component:FeedbackComponent},
  {path:'portfolio',component:PortfolioComponent},
  {path:'stanzeAffittate',component:StanzeAffitateComponent},
  {path:'prenotazioni',component:PrenotazioniComponent},

  {path:'**', component: ErrorComponent, pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  declarations: [
    NavComponent
  ],
  exports: [RouterModule, NavComponent]
})
export class AppRoutingModule { }
