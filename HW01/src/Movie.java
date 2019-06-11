
public class Movie {
    public class Movie {
        String name;
        int year;
        int rating;
        String director;
        double boxOfficeGross;
        
        public Movie(String name, int year, int rating, String director, double boxOfficeGross) {
            this.name=name;
            this.year=year;
            this.rating=rating;
            this.director=director;
            this.boxOfficeGross=boxOfficeGross;
        }
        
        public boolean equals(Movie movie) {
            if(movie==null)
                return false;
            
            // if 'movie' is not null, check if all of its attributes
            // are the same as that of the comparable movie.
            return this.name==movie.name
            && this.year==movie.year
            && this.rating==movie.rating
            && this.director==movie.director
            && this.boxOfficeGross==movie.boxOfficeGross;
            
        }
        
        public int compareTo(Movie movie) {
            if(movie==null)
            {
                return 0;
            }
            else {
                return 1;
            }
        }
        
        // concatenate all attributes into a string, using a tab as the separator 
        public String toString() {
            return this.name+"\t"
            +Integer.toString(this.year)+"\t"
            +Integer.toString(this.rating)+"\t"
            +this.director+"\t"
            +Double.toString(this.boxOfficeGross);
        }
        
    }
