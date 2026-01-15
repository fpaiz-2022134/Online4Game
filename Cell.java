public class Cell{

private Piece piece; 

public Cell(Piece piece){
    this.piece = piece;
}

public boolean isEmpty(){
    return piece == null;
}

public void setPiece(Piece piece){
    this.piece = piece;
}
public Piece getPiece(){
    return this.piece;
}
}

