import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private API_URL = 'http://moviesbackend-env.eba-szphvrxp.ap-south-1.elasticbeanstalk.com/movies';

  constructor(private http: HttpClient) { }

  getMovies(): Observable<any[]> {
    return this.http.get<any[]>(this.API_URL);
  }
}
