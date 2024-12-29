package com.jbk.operation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.jbk.config.HibernateConfig;
import com.jbk.entity.Product;

public class Operation {

	SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public String addProduct(Product product) {

		try {
			Session session = sessionFactory.openSession();

			Product dbProduct = session.get(Product.class, product.getProductId());

			if (dbProduct == null) {
				session.save(product);
				session.beginTransaction().commit();
				return "Added Successfully";
			} else {
				return "Product Already exists";
			}

		} catch (Exception e) {
			return " Something Went Wrong";
		}
	}

	public String deleteProduct(int productId) {
		Session session = sessionFactory.openSession();
		try {
			Product dbProduct = session.get(Product.class, productId);

			if (dbProduct != null) {
				session.delete(dbProduct);
				session.beginTransaction().commit();
				return "Product Deleted";
			} else {
				return "Product Not exists to delete";
			}

		} catch (Exception e) {
			return "Something Went Wrong";
		}

	}

	public Object getProductById(int productId) {
		Session session = sessionFactory.openSession();
		try {
			Product dbProduct = session.get(Product.class, productId);

			if (dbProduct != null) {

				return dbProduct;
			} else {
				return "Product Not exists";
			}

		} catch (Exception e) {
			return "Something Went Wrong";
		}
	}

	public String updateProduct(Product product) {
		try {
			Session session = sessionFactory.openSession();

			Product dbProduct = session.get(Product.class, product.getProductId());

			if (dbProduct != null) {
				session.evict(dbProduct);

				session.update(product);
				session.beginTransaction().commit();
				return "Updated Successfully";
			} else {
				return "Product Not exists to update";
			}
		} catch (Exception e) {
			return "Something went wrong";
		}

	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getAllProductsByOrder() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getLimitedProduct() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setMaxResults(2);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getLimitedProductByOrder() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setMaxResults(2);
			criteria.addOrder(Order.asc("productName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getProductByName(String name) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", name));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getProductWhosePriceIsGreaterThan(double price) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", price));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public long getproductCount() {
		Session session = sessionFactory.openSession();
		long count = 0;
		try {
			Criteria criteria = session.createCriteria(Product.class);

			criteria.setProjection(Projections.rowCount());

			List<Long> list = criteria.list();

			if (!list.isEmpty()) {
				count = list.get(0);
			}

		} catch (Exception e) {
		}
		return count;

	}

	public Double getMinPriceOfProduct() {
		Session session = sessionFactory.openSession();
		double count = 0;
		try {
			Criteria criteria = session.createCriteria(Product.class);

			criteria.setProjection(Projections.min("productPrice"));

			List<Double> list = criteria.list();

			if (!list.isEmpty()) {
				count = list.get(0);
			}

		} catch (Exception e) {
		}
		return count;

	}

	public Double getMaxPriceOfProduct() {
		Session session = sessionFactory.openSession();
		double count = 0;
		try {
			Criteria criteria = session.createCriteria(Product.class);

			criteria.setProjection(Projections.max("productPrice"));

			List<Double> list = criteria.list();

			if (!list.isEmpty()) {
				count = list.get(0);
			}

		} catch (Exception e) {
		}
		return count;

	}

	public List<Product> getproductInBetween() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);

			criteria.add(Restrictions.between("productId", 1, 4));

			list = criteria.list();

		} catch (Exception e) {
		}
		return list;

	}

	public List<Product> queryEx1() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			String hql = "FROM Product";
			Query query = session.createQuery(hql);
			list = query.list();

		} catch (Exception e) {
		}
		return list;

	}

	public List<Object[]> queryEx2() {
		Session session = sessionFactory.openSession();
		List<Object[]> list = null;
		try {
			String hql = "SELECT productId,productName,productPrice FROM Product";
			Query query = session.createQuery(hql);
			list = query.list();

		} catch (Exception e) {
		}
		return list;

	}

	public List<Product> queryEx3() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			String hql = "FROM Product WHERE productName= :pname";
			Query query = session.createQuery(hql);
			query.setString("pname", "pen");
			list = query.list();

		} catch (Exception e) {
		}
		return list;

	}

	public List<Product> getProductsByNamePattern(String namePattern) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Product WHERE productName LIKE :namePattern";
			Query<Product> query = session.createQuery(hql, Product.class);
			query.setParameter("namePattern", "%" + namePattern + "%");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
