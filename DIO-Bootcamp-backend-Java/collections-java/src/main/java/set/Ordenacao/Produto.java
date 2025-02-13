package main.java.set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto> {
    private String nome;
    private double preco;
    private long codigo;
    private int quantidade;

    public Produto(String nome, double preco, long codigo, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return codigo == produto.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "\n Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", codigo=" + codigo +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public int compareTo(Produto o) {
        return nome.compareToIgnoreCase(o.getNome());
    }


}

class ComparatorPorPreco implements Comparator<Produto>{
    @Override
    public int compare(Produto o1, Produto o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}
