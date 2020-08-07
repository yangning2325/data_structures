package erchashu.pinghengerchatree;

public class AVLtree {
		private Node root;

		public void setRoot(Node root) {
			this.root = root;
		}

		public Node getRoot() {
			return root;
		}

		public void addNodes(Node node) {
			if (root == null) {
				root = node;
			} else {
				root.add(node);
			}
		}

		public void infixOrder() {
			if (root != null) {
				root.infixOrder();
			} else {
				System.out.println("树为空！");
			}
		}

		public Node findeNode(int value) {
			if (root == null) {
				return null;
			} else {
				return root.finddeleteNode(value);
			}
		}

		public Node findeparent(int value) {
			if (root == null) {
				return null;

			} else {
				return root.deleteparent(value);
			}
		}

		public void delete(int value) {
			if (root == null) {
				return;
			} else {
				Node node = findeNode(value);
				if (node == null) {
					return;
				}
				if (root.left == null && root.right == null) {
					root = null;
					return;
				}
				Node parent = findeparent(value);
			//删除的是叶子结点
				if (node.left == null & node.right == null) {
//					if (parent.left != null&&parent.left.value==value) {
					if (parent.left==node) {
						
						parent.left = null;
					} //else if (parent.right != null&&parent.right.value==value) {
					else if (parent.right==node) {
						
					
						parent.right = null;
					}
					//删除的是其左右结点都不为空的结点
				}else if (node.left!=null&&node.right!=null) {
					int findminnode = findminnode(node.right);
					node.value=findminnode;
				}
				//删除其左结点为空或右结点为空的结点
			else {
					if (node.left!=null) {
						if (parent!=null) {
							if (parent.left==node) {
								parent.left=node.left;
							}else {
								parent.right=node.left;
							}
						}else {
							root=node.left;
						}
						
					}else {
						if (parent!=null) {
							if (parent.left==node) {
								parent.left=node.right;
							}else {
								parent.right=node.right;
							}	
						}else {
							root=node.right;
						}
						
					}
				}
			}
		}
		public int findminnode(Node node) {
			Node target=node;
			while (target.left!=null) {
				target=target.left;
			}
			//此时target指向了最小结点
			//删除最小结点
			delete(target.value);
			return target.value;
		}

	}
