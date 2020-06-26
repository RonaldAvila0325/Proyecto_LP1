package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import com.mysql.cj.protocol.Resultset;

import java.util.ArrayList;
import java.util.List;

import entidad.Proveedor;
import util.MySqlDBConexion;

@SuppressWarnings("unused")
public class ProveedorModel 
{
	public int insertaProveedor(Proveedor p) 
	{
		int salida=-1;
		
		Connection con=null;
		PreparedStatement pstm=null;
		
		try 
		{
			con=MySqlDBConexion.getConexion();
			
			String sql="insert into proveedor values(null,?,?,?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			pstm.setString(1, p.getRazonsocial());
			pstm.setString(2, p.getRUC());
			pstm.setString(3, p.getDirecicon());
			pstm.setString(4, p.getTelefono());
			pstm.setString(5, p.getCelular());
			pstm.setString(6, p.getContacto());
			pstm.setString(7, p.getEstado());
			
			System.out.println("SQL-->"+pstm);
			
			salida=pstm.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(Exception e2) 
			{				
			}
		}
		return salida;
	}
	
	//Lista a los proveedores registrados
	public List<Proveedor>listaProveedor()
	{
		ArrayList<Proveedor> data = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		try
		{
			con = MySqlDBConexion.getConexion();
			String sql ="select * from proveedor";
			pstm = con.prepareStatement(sql);
			System.out.println("SQL-->" + pstm);			
			
			rs = pstm.executeQuery();
			
			Proveedor p=null;
			while(rs.next()) 
			{
				p=new Proveedor();
				
				p.setIdProveedor(rs.getInt("idproveedor"));
				p.setRazonsocial(rs.getString("razonsocial"));
				p.setRUC(rs.getString("ruc"));
				p.setDirecicon(rs.getString("direccion"));
				p.setTelefono(rs.getString("telefono"));
				p.setCelular(rs.getString("celular"));
				p.setContacto(rs.getString("contacto"));
				p.setEstado(rs.getString("estado"));
				
				data.add(p);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return data;
	}
	
	//Actualiza la lista de los proveedores
	public int actualizaProveedor(Proveedor p) 
	{
		int actualizados=-1;
		Connection con=null;
		PreparedStatement pstm=null;
		
		try 
		{
			con=MySqlDBConexion.getConexion();
			String sql="update proveedor set razonsocial=?,ruc=?,direccion=?,telefono=?,celular=?,contacto=?,estado=?";
			pstm=con.prepareStatement(sql);
			pstm.setString(1,p.getRazonsocial());
			pstm.setString(2,p.getRUC());
			pstm.setString(3,p.getDirecicon());
			pstm.setString(4,p.getTelefono());
			pstm.setString(5,p.getCelular());
			pstm.setString(6,p.getContacto());
			pstm.setString(7,p.getEstado());
			actualizados=pstm.executeUpdate();
			System.out.println("actualizados: " + actualizados);			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return actualizados;
		
		
	}
	
	//Elimina a los proveedores
	
	public int eliminaProveedor(int idProveedor) 
	{
		int eliminados=-1;
		Connection con=null;
		PreparedStatement pstm=null;
		
		try 
		{
			con=MySqlDBConexion.getConexion();
			String sql="delete from proveedor where idproveedor=?";
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, idProveedor);
			
			eliminados=pstm.executeUpdate();
			System.out.println("eliminados: " + eliminados);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return eliminados;
	}
}
